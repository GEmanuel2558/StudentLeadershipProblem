package extensions


fun <E> Iterable<E>.replaceByValue(old: E, new: E) = map { if (it == old) new else it }

fun <E> Iterable<E>.replaceByIndex(index: Int, elem: E) = mapIndexed { listPosition, existing ->
    if (listPosition == index) elem else existing
}