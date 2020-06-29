package com.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用方法引用了类型推断,可以像使用普通方法一样调用通用方法
 * 通用方法addBox定义了一个名为U的类型参数,Java编译器可以推算出通用方法的类型参数,因此大多数情况下不需要指定这些类型参数
 * 例如为了调用泛型方法,可以使用类型见证类指定类型采纳数
 * BoxeAction.<Integer>addBox(Integer.valueof(10),list)
 * 也可不指定,通过类型自动判出
 * BoxeAction.addBox(Integer.valueof(10),list)
 */
public class BoxDemo {
    public static class BoxeAction {
        public static <U> void addBox(U u, List<Box<U>> boxes) {
            Box<U> box = new Box<>();
            box.setT(u);
            boxes.add(box);
        }

        public static <U> void outputBoxes(List<Box<U>> boxes) {
            int counter = 0;
            for (Box<U> box : boxes) {
                U boxCounter = box.getT();
                System.out.println("Box#" + counter + "counter[" + boxCounter + "]");
            }
        }

    }


    public static void main(String[] args) {
        ArrayList<Box<Integer>> list = new ArrayList<>();
        BoxeAction.addBox(Integer.valueOf(10), list);
        BoxeAction.addBox(Integer.valueOf(20), list);
        BoxeAction.addBox(Integer.valueOf(30), list);
        BoxeAction.outputBoxes(list);

        /*
         *  Box#0counter[10]
            Box#0counter[20]
            Box#0counter[30]
         * */
    }
}
