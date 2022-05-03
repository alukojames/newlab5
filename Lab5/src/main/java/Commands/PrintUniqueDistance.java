package Commands;

import Core.CollectionManager;
import Core.InputChecker;

public class PrintUniqueDistance extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;

    public PrintUniqueDistance(CollectionManager c, InputChecker i){
        this.collectionManager = c;
        this.inputChecker = i;
    }
    public  boolean execute(){
            collectionManager.printUniqueDistance();
                return true;
    }
}
