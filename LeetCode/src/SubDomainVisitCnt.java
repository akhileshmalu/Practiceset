import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Akhilesh Maloo
 * @date: 5/26/18.
 */
public class SubDomainVisitCnt {
    public static List<String> subdomainVisits(String[] cpdomains) {

        List<String> result = new ArrayList<>();
        HashMap<String ,Integer> setCnt = new HashMap<>();

        if(cpdomains == null || cpdomains.length == 0)
            return result;

        for(String domain : cpdomains) {
            String[] domainSplit = domain.split(" ");
            int count = Integer.parseInt(domainSplit[0]);
            //setCnt.put(domainSplit[1], setCnt.getOrDefault(domainSplit[1], 0) + count);

            String[] subDomain = domainSplit[1].split("\\.");

            String subDomainParts = "";
            for(int i = subDomain.length-1; i >= 0; i--) {
                subDomainParts = subDomain[i] + subDomainParts;
                setCnt.put(subDomainParts, setCnt.getOrDefault(subDomainParts, 0) + count);
                subDomainParts = "." + subDomainParts;
            }
        }

        for(Map.Entry<String, Integer> e : setCnt.entrySet()) {
            result.add(e.getValue() + " " + e.getKey());
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}
