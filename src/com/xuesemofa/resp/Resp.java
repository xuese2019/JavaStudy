package com.xuesemofa.resp;

/**
 * 类 实例
 * 1. 构造器（new）
 * 2. 静态工厂
 * 2.1.1. 静态工厂惯用命名
 * 2.1.2. form：类型转换方法，他只有单个参数，返回该类型的一个相对应的实例，例如：Date d = Date.from(instant);
 * 2.1.3. of：聚合方法，带有多个参数，返回该类型的一个实例，把它们合并起来，例如：Set<Rank> faceCards = EnumSet.of(JACK,QUEEN,KING);
 * 等等
 * 2.2.1 静态工厂（非设计模式的工厂，不是同一个东西）
 * 优点：构造器有名称、不必每次调用都创建一个新的对象、可以返回原返回类型的任何子类型的对象、所返回的对象的类可以随着每次调用而发生变化，这取决于
 * 静态工厂方法的参数值、方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在。
 * 缺点：类如果不公有的或者受保护的构造器，就不能被子类化、程序员很难发现它们。
 * 构造器或者静态工厂，都有个共同的局限性，不能很好的扩展到大量的可选参数，比如为了实现某个类中大量的可选参数而使用重叠构造器，会很难编写并且难以阅读。
 * 如果采用javabeans模式，产生的代码很容易阅读，但是在构造过程中，javaBean可能处于不一致状态。
 * 3. 建造者模式  详见Resp类
 */
public final class Resp {

    /**
     * 返回的状态码
     */
    private final int code;
    /**
     * 返回的消息
     */
    private final String msg;
    /**
     * 返回的数据载体
     */
    private final Object data;

    /**
     * 构造器
     *
     * @param builder
     */
    private Resp(Builder builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
    }


    /**
     * 静态内部类,构建器
     */
    public static class Builder {
        //        必要参数
        private final int code;
        private final String msg;

        //        非必要参数，要实现默认值
        private Object data = null;

        /**
         * 必要参数生成对象
         *
         * @param code
         * @param msg
         */
        public Builder(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        /**
         * 非必要参数set方式传参
         */
        public Builder data(Object data) {
            this.data = data;
//            注意this的域
            return this;
        }

        /**
         * 最短方式生成对象，可以链式给非必要参数传值
         */
        public Resp build() {
            return new Resp(this);
        }
    }

    /**
     * 常用值
     * 成功
     */
    public static Resp OK = new Builder(200, "成功").build();
    /**
     * 常用值
     * 失败
     */
    public static Resp ERROR = new Builder(500, "失败").build();

    /**
     * 无论何种形式 构造器还是静态工厂或构建器，都要实现toString(),这样更易于调试
     *
     * @return
     */
    @Override
    public String toString() {
        return "Resp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
