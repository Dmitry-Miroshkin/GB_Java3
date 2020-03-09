package Homework.Lesson6;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @org.junit.Test
    public void testmain1() {

        int[] array = new int[]{
                0, 1, 65, 3, 2, 5, 67, 23, 78, 4, 4, -2
        };
        int[] testarr = new int[]{-2};
        Assert.assertArrayEquals(testarr, MainClass.afterFour(array));
    }

    @org.junit.Test
    public void testmain2() throws RuntimeException {

        int[] array = new int[]{
                0, 1, 65, 3, 2, 5, 67, 23, 78, -2
        };
        try {
            MainClass.afterFour(array);
            Assert.fail("Expected RuntimeException");
        } catch (RuntimeException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @org.junit.Test
    public void testmain3() {
        int[] array = new int[]{
                0, 1, 65, 3, 2, 5, 67, 23, 78, 4, 4
        };
        int[] arrNull = new int[]{};
        Assert.assertArrayEquals(MainClass.afterFour(array), arrNull);
    }


    @Test
    public void testmain4() {
        int[] array = new int[]{
                1, 1, 1, 4, 4, 1, 4, 4
        };
        Assert.assertTrue(MainClass.isOneFour(array));
    }

    @Test
    public void testmain5() {
        int[] array = new int[]{
                1, 1, 1, 1, 1
        };
        Assert.assertFalse(MainClass.isOneFour(array));
    }

    @Test
    public void testmain6() {
        int[] array = new int[]{
                4, 4, 4, 4
        };
        Assert.assertFalse(MainClass.isOneFour(array));
    }

    @Test
    public void testmain7() {
        int[] array = new int[]{
                1, 4, 4, 5, 1, 1, 4, 4
        };
        Assert.assertFalse(MainClass.isOneFour(array));
    }
}
