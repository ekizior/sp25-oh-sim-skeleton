package hashmap;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class TestMyHashMap {
    static class Bee {
        int b;

        Bee(int b) {
            this.b = b;
        }

        @Override
        public int hashCode() {
            return -61;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Bee other) {
                return Math.abs(b - other.b) < 61;
            }
            return false;
        }
    }

    @Test
    public void testSizeBasic() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);

        // Add a mapping from "bee" -> 1
        map.put("bee", 1);
        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    public void testPutAndGetBasic() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);

        // Add a mapping from "bee" -> 1
        map.put("bee", 1);
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get("bee")).isEqualTo(1);
    }

    @Test
    public void testDuplicatePut() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);

        // Puts a mapping from "bee" -> 1
        map.put("bee", 1);
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get("bee")).isEqualTo(1);

        // Puts a mapping from "bee" -> 2
        map.put("bee", 2);
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get("bee")).isEqualTo(2);
    }

    @Test
    public void testContainsKeyBasic() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);
        assertThat(map.containsKey("bee")).isFalse();

        // Add a mapping from "bee" -> 1
        map.put("bee", 1);
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.containsKey("bee")).isTrue();
    }

    @Test
    public void testFunctionality() {
        MyHashMap<Bee, Integer> map = new MyHashMap<>();
        Bee bee1 = new Bee(1);
        Bee bee2 = new Bee(2);
        Bee bee61 = new Bee(-61);

        // Puts a mapping bee1 -> 1
        map.put(bee1, 1);
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(bee1)).isEqualTo(1);

        // Puts a mapping bee2 -> 2. bee1 and bee2 are equal
        // so no new nodes are added to the hashmap, but the value
        // is updated to 2.
        map.put(bee2, 2);
        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(bee1)).isEqualTo(2);
        assertThat(map.get(bee2)).isEqualTo(2);

        // Puts a mapping bee61 -> 61. bee61 is not equal to any
        // of the other keys, so a new node is added.
        map.put(bee61, 61);
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get(bee2)).isEqualTo(2);
        assertThat(map.get(bee61)).isEqualTo(61);
    }

    /**
     * You don't need to know how this test works. The test
     * checks whether MyHashMap is resizing correctly.
     */
    @Test
    public void testResize() {
        MyHashMap<String, Integer> m = new MyHashMap<>();
        int backingArrayCapacity = sizeOfBackingArray(m);
        for (int i = 0; i < 100000; i++) {
            m.put("hi" + i, i);
            if (1.0 * i / backingArrayCapacity > 0.75) {
                assertThat(sizeOfBackingArray(m)).isGreaterThan(backingArrayCapacity);
                backingArrayCapacity = sizeOfBackingArray(m);
            }
        }
    }

    /** Returns the length of the backing array of the given map.
     *  Be sure that you only use one instance variable to hold the buckets,
     *  otherwise this will not work properly.

     *  Don't worry about knowing how this method works. */
    private static <K, V> int sizeOfBackingArray(MyHashMap<K, V> m) {
        Class<?> clazz = m.getClass();
        if (clazz.getSuperclass().equals(MyHashMap.class)) {
            // anonymous bucketed extensions of MyHashMap
            clazz = clazz.getSuperclass();
        }
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType() == List[].class) {
                try {
                    List<MyHashMap<K, V>.Node>[] backingArray = (List[]) field.get(m);
                    return backingArray.length;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        throw new IllegalArgumentException("Could not find backing array");
    }
}
