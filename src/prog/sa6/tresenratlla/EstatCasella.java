package prog.sa6.tresenratlla;
public enum EstatCasella {
    FITXA_O, FITXA_X, BUIT;

    @Override
    public String toString(){
        return switch (this){
            case FITXA_O -> "O"; 
            case FITXA_X -> "X"; 
            case BUIT -> " "; 
        };
    }
    
    
}
