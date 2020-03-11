public class SingletonTest {

    public static void main(String []args){

        //Singleton singleton = new Singleton();
        //提示：'Singleton()' has private access in 'Singleton'
        Singleton obj = Singleton.getInstance();
        obj.getMsg();

    }

}
