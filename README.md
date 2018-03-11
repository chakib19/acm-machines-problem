# acm-machines-problem
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


