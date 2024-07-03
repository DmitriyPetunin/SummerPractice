package ru.itis.summerpractice

object SongRepo {
    fun getSongById(id: Int): Song? {
        for (song in songs) {
            if (song.id == id) {
                return song
            }
        }
        return null
    }

    val songs: List<Song> = listOf(
        Song(
            id = 1,
            name = "Ameli",
            genre = "Rap",
            url = "https://the-flow.ru/uploads/images/catalog/element/667e40ca5f90a.jpg",
            short_description = "Author: Big baby Tape and Aarne and Toxi$",
            long_description = "Big Baby Tape и Aarne выпустили совместный альбом Peekaboo — вероятно, один из самых амбициозных проектов рурэпа этого года. Топовый артист и топовый продюсер (не битмейкер) объединили свои силы и, как рассказал Тейп, на “Peekaboo” у нас полный pass [карт-бланш] на все."
            ),
        Song(
            id = 2,
            name = "Supersonic",
            genre = "Rap",
            url = "https://the-flow.ru/uploads/images/catalog/element/667e40ca5f90a.jpg",
            short_description = "Author: Big baby Tape and Aarne",
            long_description = "Big Baby Tape и Aarne выпустили совместный альбом Peekaboo — вероятно, один из самых амбициозных проектов рурэпа этого года. Топовый артист и топовый продюсер (не битмейкер) объединили свои силы и, как рассказал Тейп, на “Peekaboo” у нас полный pass [карт-бланш] на все."
        ),
        Song(
            id = 3,
            name = "ненавижу",
            genre = "Rap",
            url = "https://images.genius.com/b94137b9fce6dfe89ff5f0e1b80fb76b.1000x1000x1.jpg",
            short_description = "Mayot",
            long_description = "Mayot выпустил альбом Оба — название и обложка говорят нам, что здесь будут романтические и распевные треки. Такие как Мотылек и Сможем ли мы, выходившие отдельными синглами. "
        ),
        Song(
            id = 4,
            name = "до сих пор",
            genre = "Rap",
            url = "https://images.genius.com/b94137b9fce6dfe89ff5f0e1b80fb76b.1000x1000x1.jpg",
            short_description = "Mayot",
            long_description = "Mayot выпустил альбом Оба — название и обложка говорят нам, что здесь будут романтические и распевные треки. Такие как Мотылек и Сможем ли мы, выходившие отдельными синглами. \""
        ),
        Song(
            id = 5,
            name = "мотылёк",
            genre = "Rap",
            url = "https://images.genius.com/b94137b9fce6dfe89ff5f0e1b80fb76b.1000x1000x1.jpg",
            short_description = "Mayot",
            long_description = "Mayot выпустил альбом Оба — название и обложка говорят нам, что здесь будут романтические и распевные треки. Такие как Мотылек и Сможем ли мы, выходившие отдельными синглами. \""
        ),
        Song(
            id = 6,
            name = "Imigration Song",
            genre = "Rock",
            url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPbKVMfjlKs2hCg1AX5sUCrUINw2Tey0aXVA&s",
            short_description = "Led Zeppelin",
            long_description = "Песня построена на повторяющемся риффе и содержит отсылки к скандинавской мифологии, а воющий вокал певца Роберта Планта упоминает войну и Валгаллу."
        ),
        Song(
            id = 7,
            name = "Maria did u hear?",
            genre = "Rap",
            url = "",
            short_description = "Naper",
            long_description = " "
        ),
    )

}