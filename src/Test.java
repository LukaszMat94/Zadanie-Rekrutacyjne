import java.util.List;

public class Test {
    public static void main(String[] args) {
        SingleBlock singleBlock1 = new SingleBlock("złoty", "złoto");
        SingleBlock singleBlock2 = new SingleBlock("srebrny", "srebro");
        SingleBlock singleBlock3 = new SingleBlock("pomarańczowy", "miedz");

        CompositedBlock compositedBlock1 = new CompositedBlock("szary", "aluminium");
        CompositedBlock compositedBlock2 = new CompositedBlock("pomarańczowy", "miedz");
        CompositedBlock compositedBlock3 = new CompositedBlock("pomarańczowy", "miedz");

        //compositedBlock1 {singleBlock1, singleBlock1, singleBlock1, singleBlock2, singleBlock2, singleBlock3}
        compositedBlock1.add(singleBlock1);
        compositedBlock1.add(singleBlock1);
        compositedBlock1.add(singleBlock1);
        compositedBlock1.add(singleBlock2);
        compositedBlock1.add(singleBlock2);
        compositedBlock1.add(singleBlock3);

        //compositedBlock2 {singleBlock3, singleBlock3, singleBlock3}
        compositedBlock2.add(singleBlock3);
        compositedBlock2.add(singleBlock3);
        compositedBlock2.add(singleBlock3);

        //compositedBlock2 {singleBlock1, singleBlock2, singleBlock3}
        compositedBlock3.add(singleBlock1);
        compositedBlock3.add(singleBlock2);
        compositedBlock3.add(singleBlock3);

        //compositedBlock1 {compositedBlock2, compositedBlock3}
        compositedBlock1.add(compositedBlock2);
        compositedBlock1.add(compositedBlock3);

        Wall wall = new Wall();
        wall.addBlock(singleBlock1);
        wall.addBlock(singleBlock2);
        wall.addBlock(singleBlock3);
        wall.addBlock(compositedBlock1);

        System.out.println(wall.count());

        Block block = wall.findBlockByColor("srebrny").orElseThrow(() -> new IllegalArgumentException("Block not found"));
        System.out.println("Blok: " + block.getColor() + " Material: " + block.getMaterial());

        List<Block> blockList = wall.findBlocksByMaterial("miedz");
        System.out.println(blockList.size());
    }
}
