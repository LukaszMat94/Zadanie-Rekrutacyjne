import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks = new ArrayList<>();

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void removeBlock(Block block) {
        blocks.remove(block);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if(color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color is empty");
        } else {
            return blocks.stream().filter(block -> block.getColor().equals(color)).findFirst();
        }
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if(material == null || material.isBlank()){
            throw new IllegalArgumentException("Material is empty");
        }

        List<Block> blocksList = getBlocksMaterial(blocks, material, new ArrayList<>());

        if(blocksList.isEmpty()){
            throw new IllegalArgumentException("Block not found");
        }
        else{
            return blocksList;
        }
    }

    private List<Block> getBlocksMaterial(List<Block> blocks, String material, List<Block> blocksWithMaterial){
        for (Block block : blocks){
            if(block.getMaterial().equals(material)){
                blocksWithMaterial.add(block);
            }

            if(block instanceof CompositedBlock compositedBlock){
                return getBlocksMaterial(compositedBlock.getBlocks(), material, blocksWithMaterial);
            }
        }
        return blocksWithMaterial;
    }

    @Override
    public int count() {
        return blocks.stream().mapToInt(Block::getBlockCount).sum();
    }
}
