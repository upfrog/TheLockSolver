import java.lang.RuntimeException;

public class QueueUnderflowException extends RuntimeException
{


   public QueueUnderflowException()
   {
      super();
   }


   public QueueUnderflowException(String message)
   {
      super(message);
   }

}
