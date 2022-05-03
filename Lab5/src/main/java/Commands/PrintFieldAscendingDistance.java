package Commands;

import Core.CollectionManager;
import Core.CommandAsker;

public class PrintFieldAscendingDistance extends AbstractCommand{
    private final CollectionManager collectionManager;
    public PrintFieldAscendingDistance(CollectionManager c, CommandAsker a){
        this.collectionManager = c;
    }

    @Override
    public boolean execute(){
       collectionManager.printFieldAscendingDistance();
        return true;
    }
}
