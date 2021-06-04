/**
 * Jun 4, 2021
 */

/**
 * @author Dheeraj
 *
 */
public class PatternMatchingTabulation{
public static void main(String args[]){
char[] testValue = new String("xydhxg").toCharArray();
char[] forPattern = new String("x*?g").toCharArray();
boolean[][] table = new boolean[testValue.length+1][forPattern.length+1];
System.out.println(isMatching(testValue, forPattern ,table)?"Match found":"test value does not match with pattern");
}

static boolean isMatching(char[] testValue, char[] forPattern,boolean[][] table){
	
table[0][0] = true;
for(int k = 1;k<=forPattern.length;++k){
if(forPattern[k-1]=='*'){
table[0][k]=table[0][k-1];
}
}
for(int i=1;i<=testValue.length;++i){
for(int j=1;j<=forPattern.length;++j){
	if(forPattern[j-1]=='*'){
table[i][j]=table[i][j-1] || table[i-1][j];;
}
else if(forPattern[j-1]!='?' && forPattern[j-1]!=testValue[i-1]){
table[i][j]=false;
}
else{
table[i][j]=table[i-1][j-1];
}
}}
return table[testValue.length][forPattern.length];
}
}

