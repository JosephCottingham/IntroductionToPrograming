import java.io.PrintStream;
import java.lang.reflect.Field;


public class main {
    static int pass = 0;
    static int fail = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("========== BSTree Class Logic ==========");
        testBSTreeLogic();
        System.out.println("-------------------------------------------------");
        System.out.println("Passed: " + pass);
        System.out.println("Failed: " + fail);
        System.out.println("        --------");
        System.out.printf ("        %.2f %% correct\n", (float)pass / (fail + pass) * 100);
        System.out.println("-------------------------------------------------");
    }

    private static void testBSTreeLogic() throws Exception {
        Tree<Integer> tree = new BSTree<Integer>();

        // Default constructor initializes root to null
        BSTree.Node actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        count(assertNull(System.out, actualHead,
                "Default constructor initializes root to null"));

        // After default constructor, size() returns 0
        int expectedInt = 0;
        int actualInt = tree.size();
        count(assertEqual(System.out, expectedInt, actualInt,
                "After default constructor, size() returns 0"));

        tree.add(55);

        // After default constructor, and add(55), root is not null
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        count(assertNotNull(System.out, actualHead,
                "After default constructor, and add(55), root is not null"));

        // After default constructor, and add(55), root.left is null
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        count(assertNull(System.out, actualHead.left,
                "After default constructor, and add(55), root.left is null"));

        // After default constructor, and add(55), root.right is null
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        count(assertNull(System.out, actualHead.right,
                "After default constructor, and add(55), root.right is null"));

        // After default constructor, and add(55), head.data is 55
        expectedInt = 55;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "After default constructor, and add(55), head.data is 55"));

        tree = new BSTree<Integer>();
        tree.add(55);
        tree.add(33);
        tree.add(77);

        // Given an empty tree, after adding 55 then 33 then 77, head.data is 55
        expectedInt = 55;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "given an empty tree, after adding 55 then 33 then 77, head.data is 55"));

        // Given an empty tree, after adding 55 then 33 then 77, head.left.data is 33
        expectedInt = 33;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.left.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "given an empty tree, after adding 55 then 33 then 77, head.left.data is 33"));

        // Given an empty tree, after adding 55 then 33 then 77, head.right.data is 77
        expectedInt = 77;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.right.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding 55 then 33 then 77, head.right.data is 77"));

        tree = new BSTree<Integer>();
        tree.add(11);
        tree.add(22);
        tree.add(33);

        // Given an empty tree, after adding 11 then 22 then 33, head.data is 11
        expectedInt = 11;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding 11 then 22 then 33, head.data is 11"));

        // Given an empty tree, after adding 11 then 22 then 33, head.right.data is 22
        expectedInt = 22;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.right.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "iven an empty tree, after adding 11 then 22 then 33, head.right.data is 22"));

        // Given an empty tree, after adding 11 then 22 then 33, head.right.right.data is 33
        expectedInt = 33;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.right.right.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding 11 then 22 then 33, head.right.right.data is 33"));

        tree = new BSTree<Integer>();
        tree.add(33);
        tree.add(22);
        tree.add(11);

        // Given an empty tree, after adding 33 then 22 then 11, head.data is 33
        expectedInt = 33;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding 33 then 22 then 11, head.data is 33"));

        // Given an empty tree, after adding 33 then 22 then 11, head.left.data is 22
        expectedInt = 22;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.left.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding 33 then 22 then 11, head.left.data is 22"));

        // Given an empty tree, after adding 33 then 22 then 11, head.left.left.data is 11
        expectedInt = 11;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.left.left.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding 33 then 22 then 11, head.left.left.data is 11"));

        tree = new BSTree<Integer>();
        tree.add(55);
        tree.add(33);
        tree.add(77);
        tree.add(44);
        tree.add(66);
        tree.add(22);
        tree.add(88);

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, head.right.right.data is 88
        expectedInt = 88;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.right.right.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, head.right.right.data is 88"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, head.right.left.data is 66
        expectedInt = 66;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.right.left.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, head.right.left.data is 66"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, head.left.right.data is 44
        expectedInt = 44;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.left.right.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, head.left.right.data is 44"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, head.left.left.data is 22
        expectedInt = 22;
        actualHead = (BSTree.Node) getDeclaredFieldValue(tree, "root");
        actualInt = (int) actualHead.left.left.data;
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, head.left.left.data is 22"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(55) returns true
        boolean expectedBool = true;
        boolean actualBool = tree.contains(55);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(55) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(33) returns true
        expectedBool = true;
        actualBool = tree.contains(33);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(33) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(77) returns true
        expectedBool = true;
        actualBool = tree.contains(77);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(77) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(22) returns true
        expectedBool = true;
        actualBool = tree.contains(22);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(22) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(44) returns true
        expectedBool = true;
        actualBool = tree.contains(44);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(44) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(66) returns true
        expectedBool = true;
        actualBool = tree.contains(66);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(66) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(88) returns true
        expectedBool = true;
        actualBool = tree.contains(88);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(88) returns true"));

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(999) returns false
        expectedBool = false;
        actualBool = tree.contains(999);
        count(assertEqual(System.out, expectedBool, actualBool,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, contains(999) returns false"));

        tree = new BSTree<Integer>();
        tree.add(55);

        // After default constructor, and add(55), size returns 1
        expectedInt = 1;
        actualInt = tree.size();
        count(assertEqual(System.out, expectedInt, actualInt,
                "After default constructor, and add(55), size returns 1"));

        tree.add(55);

        // After default constructor, and calling add(55) twice, size still returns 1
        expectedInt = 1;
        actualInt = tree.size();
        count(assertEqual(System.out, expectedInt, actualInt,
                "After default constructor, and calling add(55) twice, size still returns 1"));

        tree = new BSTree<Integer>();
        tree.add(55);
        tree.add(33);
        tree.add(77);
        tree.add(44);
        tree.add(66);
        tree.add(22);
        tree.add(88);

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, size() returns 7
        expectedInt = 7;
        actualInt = tree.size();
        count(assertEqual(System.out, expectedInt, actualInt,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, size() returns 7"));

        tree = new BSTree<Integer>();

        // Given an empty tree, calling toString() returns ""
        String expectedStr = "";
        String actualStr = tree.toString().trim();
        count(assertEqual(System.out, expectedStr, actualStr,
                "Given an empty tree, calling toString() returns \"\""));

        tree = new BSTree<Integer>();
        tree.add(11);
        tree.add(22);
        tree.add(33);
        tree.add(44);
        tree.add(55);
        tree.add(66);
        tree.add(77);
        tree.add(88);

        // Given an empty tree, after adding {11,22,33,44,55,66,77,88}, calling toString() returns "11 22 33 44 55 66 77 88"
        expectedStr = "11 22 33 44 55 66 77 88";
        actualStr = tree.toString().trim();
        count(assertEqual(System.out, expectedStr, actualStr,
                "Given an empty tree, after adding {11,22,33,44,55,66,77,88}, calling toString() returns \"11 22 33 44 55 66 77 88\""));

        tree = new BSTree<Integer>();
        tree.add(99);
        tree.add(88);
        tree.add(77);
        tree.add(66);
        tree.add(55);
        tree.add(44);
        tree.add(33);
        tree.add(22);

        // Given an empty tree, after adding {99,88,77,66,55,44,33,22}, calling toString() returns "22 33 44 55 66 77 88 99"
        expectedStr = "22 33 44 55 66 77 88 99";
        actualStr = tree.toString().trim();
        count(assertEqual(System.out, expectedStr, actualStr,
                "Given an empty tree, after adding {99,88,77,66,55,44,33,22}, calling toString() returns \"22 33 44 55 66 77 88 99\""));

        tree = new BSTree<Integer>();
        tree.add(55);
        tree.add(33);
        tree.add(77);
        tree.add(44);
        tree.add(66);
        tree.add(22);
        tree.add(88);

        // Given an empty tree, after adding {55,33,77,44,66,22,88}, calling toString() returns "22 33 44 55 66 77 88"
        expectedStr = "22 33 44 55 66 77 88";
        actualStr = tree.toString().trim();
        count(assertEqual(System.out, expectedStr, actualStr,
                "Given an empty tree, after adding {55,33,77,44,66,22,88}, calling toString() returns \"22 33 44 55 66 77 88\""));
    }

    private static void count(boolean testResult) {
        if (testResult)
            pass++;
        else
            fail++;
    }

    private static boolean assertEqual(PrintStream out, int expected, int actual, String message) {
        if (expected == actual) {
            out.println("PASS - " + message);
            out.println();
            return true;
        } else {
            out.println("FAIL - " + message);
            out.printf ("!!!!   expected[%d] but got [%d]\n\n", expected, actual);
            return false;
        }
    }

    private static boolean assertEqual(PrintStream out, boolean expected, boolean actual, String message) {
        if (expected == actual) {
            out.println("PASS - " + message);
            out.println();
            return true;
        } else {
            out.println("FAIL - " + message);
            out.printf ("!!!!   expected[%b] but got [%b]\n\n", expected, actual);
            return false;
        }
    }

    private static boolean assertEqual(PrintStream out, String expected, String actual, String message) {
        if (expected.equals(actual)) {
            out.println("PASS - " + message);
            out.println();
            return true;
        } else {
            out.println("FAIL - " + message);
            out.printf ("!!!!   \n" +
                            "expected %s\n" +
                            "but got  %s\n",
                    expected, actual);
            return false;
        }
    }

    private static boolean assertNull(PrintStream out, Object actual, String message) {
        if (actual == null) {
            out.println("PASS - " + message);
            out.println();
            return true;
        } else {
            out.println("FAIL - " + message);
            out.printf ("!!!!   expected[null] but got [%s]\n\n", actual);
            return false;
        }
    }

    private static boolean assertNotNull(PrintStream out, Object actual, String message) {
        if (actual != null) {
            out.println("PASS - " + message);
            out.println();
            return true;
        } else {
            out.println("FAIL - " + message);
            out.printf ("!!!!   Value should not be null.");
            return false;
        }
    }

    private static Object getDeclaredFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

}
