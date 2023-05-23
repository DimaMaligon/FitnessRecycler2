# Создание расписания для фитнес клуба:

Приложение отображает список занятий по дням недели. Уроки относящиеся к определенному 
дню недели отделены заголовком. Карточка занятия отображает информацию о: времени начала и 
конца урока, виде занятия, имени и фамилии тренера, месте проведения.

<p  align="center">
<code><img width="35%" title="App" src="readme_images/fitness.png"></code>
</p>

## Стек используемых технологий

<p  align="left">
<code><img width="5%" title="Git" src="readme_images/github.png"></code>
<code><img width="5%" title="Gradle" src="readme_images/gradle.png"></code>
<code><img width="5%" title="Kotlin" src="readme_images/kotlin.png"></code>
<code><img width="5%" title="MVVM" src="readme_images/mvvm.png"></code>
<code><img width="5%" title="Rxjava" src="readme_images/rxjava.png"></code>
<code><img width="5%" title="Retrofit" src="readme_images/retrofit.png"></code>
</p>

## Использование Retrofit и MVVM

Сделал recyclerview, который отображает расписание занятий в фитнес-клубе.
Использовал билиотеку retrofit для работы с api. Для работы с данными и передачи их во view, 
я использовал LessonViewModel (архитектуру MVVM). 

## Использование RxJava

Чтобы подтянуть фамилию и имя тренера из списка преподавателей в каждую 
карточку занятия из списка уроков, я использовал библиотеку RxJava. Так как изначально в карте
урока нет имени и фамилии учителя, а только его id. Решил эту задачу так: после получения списков тренеров 
и занятий (с этим у нас отлично справился retrofit) я отправил их в поток computation, где дальше 
вытаскивал у каждой тренировки id преподавателя и с ним уже пробегался по списку тренеров. 
Если было совпадение, то вместо айди мы вставляем данные тренера. Плюс еще использовал BackpressureBuffer для
быстро отображения данных.

<p  align="center">
<code><img width="55%" title="App" src="readme_images/json1.png"></code>
<code><img width="55%" title="App" src="readme_images/json2.png"></code>
</p>