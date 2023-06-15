# Centroid Multithreading

`Task:`</br>
`Find the center of gravity for a set of points on the plane given coordinates and a positive weight.`

1.  A list of points is generated or read from a file.</br>
    <img width="273" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/b02a1ee1-376b-4e06-b7bc-2cc1095ce90a"></br>
2.  Enter the number of generated points (if random point generation is selected).</br>
3.  The center of gravity is calculated first with one main thread, </br>
    then by many parallel threads (2-6) </br> 
    and the result is displayed on the console along with the calculation time.</br>
    <img width="441" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/fc4e9dd5-8380-45b6-8fd6-9587bce4b19d"></br>
4.  Finally, you can save the generated list of points to a file.</br>
    <img width="267" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/9639360e-fc58-4549-acc3-046f7fbcf581"></br>
    
## Graphs of execution time results with different number of threads
### 10k points:
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/fec90f0c-fb17-4002-885d-85c4951094c4"></br>
### 100k points:
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/64a81d89-c8aa-4a52-9491-b3d8ad24b999"></br>
### 1kk points: 
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/ed2084a8-06e2-459b-a222-bb193f36ea32"></br>
### 10kk points: 
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/0ff9bfc2-0bc9-4b37-8711-9da3b1147ad1"></br>
> CPU: Intel Core i7-8665U (4 cors, 8 threads)
