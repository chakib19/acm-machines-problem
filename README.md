﻿# ACM-machines-problem
Repository to solve acm machines problem using java, gradle and eclipse

## Problem description 
You are the director of Awesomely Complex Machines (or short: ACM), a company producing
advanced machinery using even more advanced machinery. The old production machinery has broken
down, so you need to buy new production machines for the company. Your goal is to make as much
money as possible during the restructuring period. During this period you will be able to buy and sell
machines and operate them for profit while ACM owns them. Due to space restrictions, ACM can own
at most one machine at a time. During the restructuring period, there will be several machines for sale.
Being an expert in the advanced machines market, you already know the price P i and the availability
day D i for each machines M i . Note that if you do not buy machine M i on day D i then somebody else
will buy it and it will not be available later. Needless to say, you cannot buy a machine if ACM has less
money than the price of the machine. If you buy a machine M i on day D i then ACM can operate it
starting on day D i + 1. Each day that the machine operates, it produces a profit of G i dollars for the
company.
You may decide to sell a machine to reclaim a part of its purchase price any day after you’ve bought it.
Each machine has a resale price R i for which it may be resold to the market. You cannot operate a
machine on the day that you sell it, but you may sell a machine and use the proceeds to buy a new
machine on the same day. Once the restructuring period ends, ACM will sell any machine that it still
owns. Your task is to maximize the amount of money that ACM makes during the restructuring.
## Input
The input consists of several test cases. Each test case starts with a line containing three positive
integers N , C , and D . N is the number of machines for sale (N ≤ 10 5 ), C is the number of dollars with
which the company begins the restructuring (C ≤ 10 9 ), and D is the number of days that the
restructuring lasts ( D ≤ 10 9 ).
Each of the next N lines describes a single machine for sale. Each line contains four integers D i , P i , R i
and G i denoting (respectively) the day on which the machine is for sale, the dollar price for which it
may be bought, the dollar price for which it may be resold and the daily profit generated by operating
the machine. These numbers satisfy the following conditions:
1 ≤ D i ≤ D
1 ≤ R i < P i ≤ 10 9
1 ≤ G i ≤ 10 9
The last test case is followed by a line containing three zeros.
## Output
For each test case, display its case number followed by the largest number of dollars that ACM can
have at the end of day D + 1 . Follow the format of the sample output.
Example Input Example Output
6 10 20 Case 1: 44


....

'''
Gradle Test Executor 1 started executing tests.

optim.tests.ACMMachinesTest > testFromFile STANDARD_OUT
    18:37:33.988 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing from file: src/test/resources/scenarios.txt
Gradle Test Executor 1 finished executing tests.
    18:37:34.003 [Test worker] ERROR o.OptimizationInstanceFileBuilder - Wrong integer format in file 'src/test/resources/scenarios.                                                            txt'
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 1: 44
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 2: 11
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 3: 12
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 4: 10
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 5: 39
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 6: 39

optim.tests.ACMMachinesTest > test1 STANDARD_OUT
    18:37:34.003 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing case1:
    6 10 20
    6 12 1 3
    1 9 1 2
    3 2 1 2
    8 20 5 4
    4 11 7 4
    2 10 9 1
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 1: 44

optim.tests.ACMMachinesTest > test2 STANDARD_OUT
    18:37:34.003 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing case2:
    0 11 30
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 2: 11

optim.tests.ACMMachinesTest > test3 STANDARD_OUT
    18:37:34.003 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing case3:
    1 12 30
    30 10 5 3
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 3: 12

optim.tests.ACMMachinesTest > test4 STANDARD_OUT
    18:37:34.003 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing case4:
    1 10 2
    1 10 2 1
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 4: 10

optim.tests.ACMMachinesTest > test5 STANDARD_OUT
    18:37:34.003 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing case5:
    2 10 11
    1 10 4 3
    1 10 9 3
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 5: 39

optim.tests.ACMMachinesTest > test6 STANDARD_OUT
    18:37:34.003 [Test worker] INFO  optim.tests.ACMMachinesTest - Testing case6:
    2 10 11
    1 10 9 3
    1 10 4 3
    18:37:34.003 [Test worker] INFO  optimization.OptimizationInstance - case 6: 39
Finished generating test XML results (0.021 secs) into: C:\Users\COMPUTER\git\acm-machines-problem\build\test-results\test
Generating HTML test report...
Finished generating test html results (0.168 secs) into: C:\Users\COMPUTER\git\acm-machines-problem\build\reports\tests\test
:test (Thread[Daemon worker,5,main]) completed. Took 2.625 secs.

BUILD SUCCESSFUL in 31s
5 actionable tasks: 5 executed
VCS Checkout Cache (C:\Users\COMPUTER\git\acm-machines-problem\.gradle\vcsWorkingDirs) has not been cleaned up in 0 days
'''