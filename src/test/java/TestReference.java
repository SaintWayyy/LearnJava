import org.junit.Test;
import reference.References;

public class TestReference {
    @Test
    public void testReference() throws InterruptedException {
        References reference = new References();
        System.out.println(reference.strongRef);
        System.out.println(reference.softRef.get());
        System.out.println(reference.weakRef.get());
        System.out.println(reference.phantomRef.get());
        System.out.println();
        System.gc();


        System.out.println(reference.strongRef);
        System.out.println(reference.softRef.get());
        System.out.println(reference.weakRef.get());
        System.out.println(reference.phantomRef.get());
        System.out.println();

        java.lang.ref.Reference<?> ref;
        do{
            ref = reference.refQue.poll();
            if(ref != null)
                System.out.println(ref);
        }
        while (ref != null);
    }
}
