class Singleton {

    private static Singleton instance;

    //防止实例化，构造函数私有化
    private Singleton(){}

    //需要时获取实例
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    //msg
    public void getMsg(){
        System.out.println("牛逼");
    }

}
