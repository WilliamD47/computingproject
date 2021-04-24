#include <string>
#include <list>
#include <iostream>
#include <numeric>
int main() {
    bool listDone = false;
    std::string password = "password";
    std::string username = "username";
    std::list<std::string> students;
    std::list<std::string> averages;
    std::list<int> score1only;
    std::list<int> score2only;
    std::list<int> score3only;
    int maxscore1 = 0;
    int maxscore2 = 0;
    int maxscore3 = 0;
    std::cout << "Please enter a username" << std::endl;
    std::string entereduser;
    std::cin >> entereduser;
    if(entereduser == username) {
        std::string enteredpass;
        std::cout << "Please enter a password \n";
        std::cin >> enteredpass;
        if(enteredpass == password) {
            std::cout << "Correct Username and Password\n";
        }
    } else{
        std::cout << "Incorrect username/password" << std::endl;
        exit(0);
    }
    std::cout << "You have got through!" << std::endl;
    while(true) {
        std::string choice;
        std::cout << "Please say either 'Add', 'List', or 'Done'\n";
        std::cin >> choice;
        if(choice == "Add") {
            std::string name;
            std::cout << "Please enter the name of the Student\n";
            std::cin >> name;
            int score1;
            std::cout << "Please enter the first score\n";
            std::cin >> score1;
            if(maxscore1 == 0) {
                std::cout << "Please enter the maximum score for score 1\n";
                std::cin >> maxscore1;
            }
            int score2;
            std::cout << "Please enter the second score\n";
            std::cin >> score2;
            if(maxscore2 == 0) {
                std::cout << "Please enter the maximum score for score 2\n";
                std::cin >> maxscore2;
            }
            int score3;
            std::cout << "Please enter the third score\n";
            std::cin >> score3;
            if(maxscore3 == 0) {
                std::cout << "Please enter the maximum score for score 3\n";
                std::cin >> maxscore3;
            }
            std::string message = name + "'s first score was " + std::to_string(score1) + " out of " + std::to_string(maxscore1) + ". Their second score was " + std::to_string(score2) + " out of " + std::to_string(maxscore2) + ". Their third score was " + std::to_string(score3) + " out of " + std::to_string(maxscore3) + ".";
            students.push_back(message);
            score1only.push_back(score1);
            score2only.push_back(score2);
            score3only.push_back(score3);
        } else if(choice == "List") {
            listDone = true;
            std::cout << "Student Scores: \n";
            for (std::string item : students)
                std::cout << item << " \n";
            std::cout << "Averages: \n";
            int sum1 = std::accumulate(std::begin(score1only), std::end(score1only), 0.0);
            int avg1 = sum1 / score1only.size();
            averages.emplace_back("For score 1:");
            averages.emplace_back(std::to_string(avg1));
            int sum2 = std::accumulate(std::begin(score2only), std::end(score2only), 0.0);
            int avg2 = sum2 / score2only.size();
            averages.emplace_back("For score 2:");
            averages.emplace_back(std::to_string(avg2));
            int sum3 = std::accumulate(std::begin(score3only), std::end(score3only), 0.0);
            int avg3 = sum3 / score1only.size();
            averages.emplace_back("For score 3:");
            averages.emplace_back(std::to_string(avg3));
            for (std::string item : averages)
                std::cout << item << " \n";
        } else if(choice == "Done") {
            if(listDone) {
                std::cout << "Bye!";
                exit(0);
            } else {
                std::string choice2;
                std::cout << "Are you sure you want to exit? You have not read the scores!\n";
                std::cin >> choice2;
                if(choice2 == "Yes") {
                    std::cout << "Bye!";
                    exit(0);
                } else {
                    ;
                }
            }
        }
    }
}
