# Flowtree

There are many mature network technologies in the market such as zigbee, z-wave, echonet, which can collect home or building meter data into distributed central database. assume we collect data every 15 minutes and store into some data storage, e.g. csv file, hdfs, database, the data format may look like the following:

Unix Time MS, Meter Id, City, Region, Power Usage

1483228800, 123, 456, 678, 10 

Let’s do the following:

1> How big data will be in 1 year, 5 years, 10 years, etc…, find an algorithm to simulate the data or search online to find public data.

2> How we store data into some data storage, e.g. csv file, hdfs, nosql or sql database, etc…

3> How to aggregate data by location: city, region and by time: hour, day, month, year

4> There is usually power usage peak in summer, let’s predicate when it will be coming summer.

We have 3 teams by course: DS-200(Hadoop), DS-300(Spark), DS-400(AI). Each team should focus on using its own technology to solve the related problem by choosing right tools, right solutions, etc…

You may reference Google TensorFlow, GE Predix or AutoGrid. Assume they are your strong competitors, you are challenged to work out a plan to beat them!

If you finish the project, we encourage you join TopCoder competition by GE and get recognized by the industry.  Here is the link: http://predix.topcoder.com/
