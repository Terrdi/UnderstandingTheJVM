package org.fenixsoft.jvm.chapter3;

/**
 * @author <a href="mailto:675464934@qq.com">Terrdi</a>
 * @date 2020/11/28
 * @since 1.8
 **/
public class MainApp {
    public static void main(String[] args) {
        /**
         * JVM 参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
         * 对象优先在 eden 区分配
         */
//        TestSerialGCAllocation.testAllocation();
        /**
         * JVM 参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
         * -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
         * 对象超过 3145728(3M) 直接在老年代分配
         */
//        TestSerialGCAllocation.testPretenureSizeThreshold();

        /**
         * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
         * -XX:+PrintTenuringDistribution -XX:+UseSerialGC
         * 对象逃过一次GC直接进入老年代
         */
//        TestSerialGCAllocation.testTenuringThreshold();

        /**
         * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
         * -XX:+PrintTenuringDistribution -XX:+UseSerialGC
         * 如果在 Survivor 空间中低于或等于某年龄的所有对象大小的综合大于Survivor空间的一般，年龄大于或等于该年龄的对象可以直接进入老年代
         */
//        TestSerialGCAllocation.testTenuringThreshold2();

        /**
         * JVM参数: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HandlePromotionFailure=true/false -XX:+UseSerialGC
         * JDK 6 Update 24 之前 HandlePromotionFailure = true 时， 当前提升到老年代的对象总大小大于以往提升到老年代的对象平均大小, 则启动一次FullGC
         * JDK 6 Update 24 之后的规则变为只要老年代的连续空间大于新生代对象总大小或者历次晋升的平均大小，就会进行 Minor GC，否则将进行 Full GC
         */
        TestSerialGCAllocation.testHandlePromotion();
    }
}
