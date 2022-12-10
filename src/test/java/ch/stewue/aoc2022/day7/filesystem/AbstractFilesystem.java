package ch.stewue.aoc2022.day7.filesystem;

public class AbstractFilesystem {
    /*
    - / (dir)
      - d1 (dir)
        - d11 (dir)
          - f111 (file, size=10)
          - f112 (file, size=27)
        - f12 (file, size=22)
        - f13 (file, size=7)
      - f2 (file, size=32)
      - d3 (dir)
        - f31 (file, size=53)
      - d4 (dir)
     */
    protected static final Directory ROOT = new Directory("/", null);
    protected static final Directory D1 = new Directory("d1", ROOT);

    protected static final Directory D11 = new Directory("d11", D1);

    protected static final File F2 = new File("f2", 32);
    protected static final Directory D3 = new Directory("d3", ROOT);
    protected static final Directory D4 = new Directory("d4", ROOT);

    static {
        ROOT.addElement(D1);
        D1.addElement(D11);
        File f111 = new File("f111", 10);
        D11.addElement(f111);
        File f112 = new File("f112", 27);
        D11.addElement(f112);
        File f12 = new File("f12", 22);
        D1.addElement(f12);
        File f13 = new File("f13", 7);
        D1.addElement(f13);

        ROOT.addElement(F2);
        ROOT.addElement(D3);
        File f31 = new File("f31", 53);
        D3.addElement(f31);
        ROOT.addElement(D4);
    }
}
