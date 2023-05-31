# Centroid Multithreading

`Завдання: 
Знайти центр тяжіння для набору точок на площині, заданих координатами та додатнім значенням ваги.`

1.  Генерується список точок, або зчитується із файлу. </br>
    <img width="248" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/3aca697a-087c-443c-aa23-0328797cfdb4"></br>
2.  Вводиться кількість генерованих точок (якщо вибрана генерація випадкових точок) </br>
3.  Розраховується центр тяжіння спочатку одним головним потоком, </br>
    потім багатьма паралельними потоками (2-6) </br> 
    та виводиться результат на консоль разом із часом розрахунків.
    <img width="446" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/d1b7a604-fff0-4e0b-942b-38c585b626a6"></br>
4.  Вкінці є можливість зберегти згенерований список точок до файлу.</br>
    <img width="268" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/9a4cdfc1-868b-42e0-aafc-6c119cc58f6a"></br>
    
## Графіки результатів часу виконання з різною к-стю потоків
### 10 тис. точок:
  <img width="272" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/731f7477-a6d7-4124-b51b-09adbc942698"></br>
### 100 тис. точок:
  <img width="272" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/e75ca298-f46f-4955-8ede-99d67e782834"></br>
### 1 млн. точок: 
  <img width="272" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/1297567a-5b9f-40a0-8ddc-827e7f66a588"></br>
### 10 млн. точок: 
  <img width="272" alt="image" src="https://github.com/pmrochko/centroid-multithreading/assets/106275010/58bc001f-f38d-4cb5-8247-f66def6e63b4"></br>
> Процесор: Intel Core i7-8665U (4 ядра, 8 потоків)
