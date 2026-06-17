package org.easy.designhashset;

public class Main {
    public static void main(String[] args) {

        MyHashSet s1 = new MyHashSet();
        s1.add(971);
        assert s1.contains(971) : "971 should be present after add";

        MyHashSet s2 = new MyHashSet();
        assert !s2.contains(971) : "971 should not be present in empty set";

        MyHashSet s3 = new MyHashSet();
        s3.add(278);
        s3.add(971);
        s3.remove(278);
        assert s3.contains(971) : "971 should still be present after removing colliding key 278";

        MyHashSet s4 = new MyHashSet();
        s4.add(119);
        s4.add(279);
        s4.add(439);
        s4.remove(279);
        assert s4.contains(119) : "119 should survive after removing middle collision node";
        assert s4.contains(439) : "439 should survive after removing middle collision node";

        MyHashSet s5 = new MyHashSet();
        s5.add(119);
        s5.add(279);
        s5.remove(119);
        assert s5.contains(279) : "279 should survive after removing head collision node";

        MyHashSet s6 = new MyHashSet();
        s6.add(971);
        s6.remove(278);
        assert s6.contains(971) : "971 should still be present after removing absent key";
        assert !s6.contains(278) : "278 was never added";

        MyHashSet s7 = new MyHashSet();
        s7.add(203);
        s7.add(491);
        s7.add(683);
        s7.add(971);
        s7.add(747);
        s7.remove(203);
        s7.remove(491);
        assert s7.contains(971) : "971 should be present - exact sequence from index 661 failure";
        assert s7.contains(683) : "683 should be present";
        assert s7.contains(747) : "747 should be present";

        System.out.println("All assertions passed");
    }
}
