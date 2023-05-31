# Centroid Multithreading

`Завдання:`</br>
`Знайти центр тяжіння для набору точок на площині, заданих координатами та додатнім значенням ваги.`

1.  Генерується список точок, або зчитується із файлу. </br>
    <img width="273" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/b02a1ee1-376b-4e06-b7bc-2cc1095ce90a"></br>
2.  Вводиться кількість генерованих точок (якщо вибрана генерація випадкових точок) </br>
3.  Розраховується центр тяжіння спочатку одним головним потоком, </br>
    потім багатьма паралельними потоками (2-6) </br> 
    та виводиться результат на консоль разом із часом розрахунків.</br>
    <img width="441" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/fc4e9dd5-8380-45b6-8fd6-9587bce4b19d"></br>
4.  Вкінці є можливість зберегти згенерований список точок до файлу.</br>
    <img width="267" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/9639360e-fc58-4549-acc3-046f7fbcf581"></br>
    
## Графіки результатів часу виконання з різною к-стю потоків
### 10 тис. точок:
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/fec90f0c-fb17-4002-885d-85c4951094c4"></br>
### 100 тис. точок:
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/64a81d89-c8aa-4a52-9491-b3d8ad24b999"></br>
### 1 млн. точок: 
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/ed2084a8-06e2-459b-a222-bb193f36ea32"></br>
### 10 млн. точок: 
  <img width="293" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/0ff9bfc2-0bc9-4b37-8711-9da3b1147ad1"></br>
> Процесор: Intel Core i7-8665U (4 ядра, 8 потоків)
