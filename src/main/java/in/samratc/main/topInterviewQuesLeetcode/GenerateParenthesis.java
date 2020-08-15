package in.samratc.main.topInterviewQuesLeetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/submissions/
public class GenerateParenthesis {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void generate(StringBuilder curr, int open, int close, int max){
        if(curr.length() == 2*max){
            ans.add(curr.toString());
            return;
        }
        if(open < max){
            curr.append('(');
            generate(curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(close < open){
            curr.append(')');
            generate(curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
