package Commands;

import Core.CollectionManager;
import Core.CommandAsker;

public class AddIfMax extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final CommandAsker commandAsker;
    public AddIfMax (CollectionManager c, CommandAsker a){
        this.collectionManager = c;
        this.commandAsker = a;
    }

    @Override
    public boolean execute(){
        collectionManager.addIfMax(commandAsker.createRoute());
        return true;
    }
}
