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

    //在第index位置，插入一个新元素e
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("add执行失败");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index<0||index>size执行失败");

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;

    }

    //获取index 索引位置的元素
    int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index.is illgal.");
        return data[index];
    }

    //修改index索引位置的元素为e
    void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index.is illgal.");
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public  int remove(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Remove failed.Index is illegel");
        int ret =data[index];
        for (int i = index+1   ; i <size ; i++)
            data[i-1]=data[i];
        size--;
        return  ret;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}
