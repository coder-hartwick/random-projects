#include <iostream>
using namespace std;

/******************************************************************************
 * Author: Jordan Hartwick
 * Date: May 30, 2016 @ 7:05 PM
 * Usage: ./main
 *
 *          You can also use the following commands in the order shown:
 *          1. g++ main.cpp
 *          2. ls
 *          3. ./*.out where * is the ".out" file's name.
 *
 * Purpose: To create a number pyramid for the Emperor.
 *
 * Test Run:
 ******************************************************************************
 * ./main
 * How many levels would you like, Emperor? 5
 * We will begin building your pyramid. Please, relax.
 *     1
 *
 *    121
 *
 *   12321
 *
 *  1234321
 *
 * 123454321
 ******************************************************************************
 */
int main()
{
    cout << "How many levels would you like, Emperor? ";
    int num;
    cin >> num;

    cout << "We will begin building your pyramid. Please, relax." << endl;

    for(int i = 1; i <= num; i++) {
        int spaces = num - i;

        // Print the leading spaces.
        for(int j = 0; j < spaces; j++) {
            cout << " ";
        }

        // Print the numbers going forwards.
        for(int k = 1; k <= num - spaces; k++) {
            cout << k;
        }

        // Print the numbers going backwards.
        for(int l = num - spaces - 1; l > 0; l--) {
            cout << l;
        }

        cout << "\n";
    }

    cout << "We have finished building your pyramid!" << endl;
}
