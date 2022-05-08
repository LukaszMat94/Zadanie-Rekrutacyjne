import java.util.ArrayList;
import java.util.List;

public class CompositedBlock extends SingleBlock implements CompositeBlock{

    private List<Block> blocks = new ArrayList<>();

    public void add(Block block){
        blocks.add(block);
    }

    public void remove(Block block){
        blocks.add(block);
    }

    public CompositedBlock(String color, String material){
        super(color, material);
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
