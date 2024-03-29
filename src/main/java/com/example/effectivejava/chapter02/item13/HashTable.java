package com.example.effectivejava.chapter02.item13;

public class HashTable implements Cloneable {

    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void add(Object key, Object value) {
            this.next = new Entry(key, value, null);
        }
//        public Entry deepCopy() {   // 재귀적으로 구현하면 stack 쌓여 stackOverflow가 발생할 수 있다.
//            return new Entry(key, value, next == null ? null : next.deepCopy());
//        }

        public Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null ; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    /**
     * TODO hasTable -> entryH[],
     * TODO copy -> entryC[]
     * TODO entryH[0] == entryC[0]
     */
//    @Override
//    public HashTable clone() {
//        HashTable result = null;
//        try {
//            result = (HashTable) super.clone();
//            result.buckets = this.buckets.clone();  // p82, shallow copy 라서 위험하다.
//            return result;
//        }catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    /**
     * TODO hasTable -> entryH[],
     * TODO copy -> entryC[]
     * TODO entryH[0] != entryC[0]
     */
    @Override
    public HashTable clone() {
        HashTable result = null;
        try {
            result = (HashTable) super.clone();
            result.buckets = new Entry[this.buckets.length];
//            result.buckets = creataNewBuckets();
            for (int i = 0; i < this.buckets.length; i++) {
                if(buckets[i] != null) {
                    result.buckets[i] = this.buckets[i].deepCopy(); // p83, deep copy
                }
            }
            return result;
        }catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 재정의할 수 있는 메서드 사용 X -> 하위 클래스에서 오버라이딩하면 동작이 변경될 수 있음
//    protected Entry[] creataNewBuckets() {
//        throw new AssertionError();
//    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Entry entry = new Entry(new Object(), new Object(), null);
        hashTable.buckets[0] = entry;
        HashTable clone = hashTable.clone();
        System.out.println(hashTable.buckets[0] == entry);              // true
        System.out.println(hashTable.buckets[0] == clone.buckets[0]);   // shallow copy : true // deep copy : false
    }
}
