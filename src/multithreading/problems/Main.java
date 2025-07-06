package multithreading.problems;


class Methods{
    public synchronized void sai(){
        System.out.println("sai");
    }

    //Above method is same as below... putting synchronized keyword is shortcut to below snippet
//    public void sai(){
//        synchronized (this){
//            System.out.println("sai");
//        }
//    }

    public synchronized static void methodStatic(){ //this will take lock on monitor Object of Methods.class as static method is class level
        System.out.println("methodStatic");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            // do exception handling
        }
    }

    public static void methodStaticSynchronized(){
        //we're putting lock on monitor Object of Methods.class
        synchronized (Methods.class){
            System.out.println("methodStaticSynchronized");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                // do exception handling
            }
        }

    }

    public void method1(){
        synchronized (this){
            System.out.println("method1");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                // do exception handling
            }
        }
    }
    public void method2(){
        synchronized (this){
            System.out.println("method2");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                // do exception handling
            }
        }
    }
    public void method3(){
        synchronized (this){
            System.out.println("method3");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                // do exception handling
            }
        }
    }
    public  void method4(){
        synchronized (this){
            System.out.println("method4");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                // do exception handling
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        //****** Use Case 1 Starts ************
//        Methods methods = new Methods();
//        //here all methods are executing using 1 methods instance, so only 1 method will get executed once.
//        Thread thread1 = new Thread(methods::method1); // same as  ()-> methods.method1()
//        Thread thread2 = new Thread(methods::method2);
//        Thread thread3 = new Thread(methods::method3);
//        Thread thread4 = new Thread(methods::method4);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();

        //****** Use Case 1 Ends ************

        //****** Use Case 2 Starts ************

//        Methods methods2 = new Methods();
//        Methods methods3 = new Methods();
//        Thread thread5 = new Thread(methods3::method1); //thread5 and thread6 will take lock on methods instance
//        Thread thread6 = new Thread(methods3::method2);
//        Thread thread7 = new Thread(methods2::method3); //thread7 and thread8 will take lock on methods2 instance
//        Thread thread8 = new Thread(methods2::method4);
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//         (thread5 or thread6) & (thread7 or thread8) will execute parallel as they acquire lock on different instances

        //****** Use Case 2 Ends ************

        //****** Use Case 3 Starts ************
//        Methods methods1 = new Methods();
//        Thread thread9 = new Thread(methods1::method1); //acquires lock on methods1 instance
//        Thread thread10 = new Thread(Methods::methodStatic); //acquires lock on Methods.class
//        thread9.start();
//        thread10.start();
        //now these both can run parallel as these two threads acquires different locks

        //****** Use Case 3 Ends ************

        //****** Use Case 4 Starts ************
        Thread thread11 = new Thread(Methods::methodStaticSynchronized); //acquires lock on Methods.class
        Thread thread12 = new Thread(Methods::methodStatic); //acquires lock on Methods.class
        thread11.start();
        thread12.start();
        //these cannot be run parallel as both threads trying to acquire lock on same object


    }

}
