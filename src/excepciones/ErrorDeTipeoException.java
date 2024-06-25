package excepciones;

public class ErrorDeTipeoException extends NumberFormatException{
    private String mensaje;

    public ErrorDeTipeoException (String mensaje){
        this.mensaje = "Formato de la entrada incorrecto, pruebe nuevamente.";
    }

    @Override
    public String getMessage(){
        return this.mensaje;
    }
}
