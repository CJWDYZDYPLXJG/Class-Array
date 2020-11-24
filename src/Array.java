public class Array {
    private int[] data;
    private int size;

    //构造函数，传入数组的容量caoacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的容量Capacity=10
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    //在第index个为止插入一个新元素e
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("add执行失败");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index<0||index>size执行失败");

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

            data[index] = e;
            size++;
        }
    }
}
