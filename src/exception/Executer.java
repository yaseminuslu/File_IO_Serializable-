package exception;

public class Executer {
    Divider divider = new Divider();
    public void exec(){
        try {
            divider.divide();
        }catch (ArithmeticException e){
            System.out.println("Bu işlem yapılamaz: " +e);
            throw new MyUncheckedException("unchecked exception");
        }catch (MyCheckedException e){
            System.out.println("Checked Exception "+e);
        }
    }
}
