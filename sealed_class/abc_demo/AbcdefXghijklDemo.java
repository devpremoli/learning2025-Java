package sealed_class.abc_demo;

// Only B, C, D can extend A
sealed class A permits B, C, D {
}

// only E can extend B
sealed class B extends A permits E {
}

// No class can extend C
final class C extends A {
}

// Any class can extend D
non-sealed class D extends A {
}

// No class can extend B
final class E extends B{
}

class F extends D {
}



// Only G, H, and I are allowed to implement X
sealed interface X permits G, H, I {
    void display();
}

// Only J is allowed to implement G
sealed interface G extends X permits J {
}

// Sealed Interface J: Only K is allowed to implement J
sealed interface J extends G permits K {
}

// Final Class K: Implements J → G → X (Sealed interface)
final class K implements J {
    @Override
    public void display() {
        System.out.println("K implements J, G, and X");
    }
}

// Final Class H: Implements X but cannot be extended further
final class H implements X {
    @Override
    public void display() {
        System.out.println("H implements X");
    }
}

// Non-sealed Interface I: Allows unrestricted implementation
non-sealed interface I extends X {
}

// Regular Class E: Implements I (Non-sealed, so allowed)
class L implements I {
    @Override
    public void display() {
        System.out.println("L implements I and X");
    }
}

public class AbcdefXghijklDemo {
}
