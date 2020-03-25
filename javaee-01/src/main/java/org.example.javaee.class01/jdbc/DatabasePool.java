package org.example.javaee.class01.jdbc;

public class DatabasePool {
    private  static HikariDataSource hikariDataSource;
    /**
     * 加一个双锁
     * */
    public static HikariDataSoure getHikarDataSourse(){
        if (null!=hikariDataSource){
            return hikariDataSource;
        }
        synchronized (DatabasePool.class) {
            if(null==hikariDataSource){
            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
            String driverName="com.mysql.cj.jdbc.Driver";
            HikariConfig hikariConfig = new HikarConfig();
            hikariConfig.setUsername("root");
            hikariConfig.setPassword("123456");
            hikariConfig.setDriverClasssName(driverName);
            hikariConfig.setJdbcUrl(jdbcUrl);
            HikariDataSourse hikariDataSourse = new HikariDataSource(hikariConfig);
            return hikariConfig;
            }
        }
        return hikariConfig;
    }
    public static  void main(String[] args)   {
        while (true){
        getHikarDataSourse();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
