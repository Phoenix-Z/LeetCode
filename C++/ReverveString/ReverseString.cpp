#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
using namespace std;

class Solution {
public:
    string reverseString(string s) {
        //reverse the string to a new string
/*        string s1;
        s1.assign(s.rbegin(), s.rend());
        return s1;
*/
        //reverse the string itself
            std::reverse(s.begin(), s.end());
            return s;
    }
};

int main()
{
    Solution s;
    string str = s.reverseString("hello");
    cout<<str<<endl;
}
