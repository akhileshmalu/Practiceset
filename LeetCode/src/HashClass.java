import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 3/26/18.
 */
public class HashClass {

    class HNode {

        Integer key;
        Integer val;

        public HNode(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    List<List<HNode>> bucket;

    private int maxCapacity;
    private int size;

    public HashClass() {
        bucket = new ArrayList<>();
        maxCapacity = 16;
        for(int i = 0; i < maxCapacity; i++) {
            bucket.add(new ArrayList<>());
        }
        size = 0;
    }


    public int getIndex(Integer k) {
        return (k.hashCode() & 0x7ffffff) % maxCapacity;
    }

    public void insert(int k, int v) {

        if( (size * 100) / maxCapacity > 75) {
            resize();
        }

        int index = getIndex(k);

        if(bucket.get(index) == null) {
            bucket.add(new ArrayList<>(Arrays.asList(new HNode(k, v))));
            size++;
        } else {
            List<HNode> bucIndex = bucket.get(index);
            int count = 0;
            while(count < bucIndex.size()) {
                if(bucIndex.get(count).key == k) {
                    bucIndex.get(count).val = v;
                    break;
                }
                count++;
            }
            if(count == bucIndex.size()) {
                bucIndex.add(new HNode(k, v));
                size++;
            }
        }

    }

    public Integer getVal(int k) {

        int index = getIndex(k);

        if(bucket.get(index) == null)
            return null;

        List<HNode> bucIndex = bucket.get(index);
        int count = 0;
        while(count < bucIndex.size()) {
            if(bucIndex.get(count).key == k) {
                return bucIndex.get(count).val;
            }
            count++;
        }

        return null;

    }

    private void resize() {
    }
}


