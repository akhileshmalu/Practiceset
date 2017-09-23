/**
 * Created by akhi on 5/17/17.
 */
public class FirstBadVersion {

//    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//    You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

    static int[] num = {1,2,3,4,0,0,0,0,0};
    int actualFirstBad = 6;

    public static void main(String[] args) {

        FirstBadVersion ex = new FirstBadVersion();
        System.out.println(ex.firstBadVersion(num.length));


    }
    public int firstBadVersion(int n) {
        int first=1,end=n,mid;
        while(end-first>0){
            mid=first+(end-first)/2;
            if(isBadVersion(mid)) end=mid;
            else first=mid+1;
        }
        return end;
    }
    public boolean isBadVersion(int n) {
        if(num[n] == 0)
            return true;
        return false;
    }

}

