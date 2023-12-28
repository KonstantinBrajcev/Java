Создайте несколько экземпляров Pharmacy(или IterablePharmacy), причем, чтобы среди них было хотя бы два экземпляра
с полностью идентичными значениями полей.

Сделать так, чтобы после выполнения кода ниже, в сете result были только уникальные объекты.
Set<Pharmacy> result = new HashSet<>(множество из нескольких лекарств);
System.out.println(result.size()); // тут вывод должен быть равен количеству УНИКАЛЬНЫХ экземпляров Pharmacy!

Добавить интерфейс Copmparable<Pharmacy> к классу Pharmacy. Переопределить метод compareTo()
подсказка: можно добавить, а можно не добавлять в класс поля;

ссылка на статью о equals и hashCode: https://javarush.com/groups/posts/2179-metodih-equals--hashcode-praktika-ispoljhzovanija