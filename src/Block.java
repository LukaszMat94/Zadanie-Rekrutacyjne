public interface Block {
    String getColor();
    String getMaterial();

    default int getBlockCount(){
        return 1;
    }
}