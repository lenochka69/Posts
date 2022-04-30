import junit.framework.Assert.assertFalse
import junit.framework.TestCase.assertEquals
import junit.runner.Version.id
import org.junit.Assert.assertTrue
import org.junit.Test


class WallServiceTest {

    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()

        // создаем и добавляем в посты
        val addedPost = service.add(
            Post(
                id = 1,
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 1,
                text = "First post",
                replyOwnerId = 1,
                replyPostId = 1,
                comments = null,
                copyright = null,
                likes = null,
                reposts = null,
                views = null,
                postType = "1",
                signerId = 1,
                postponedId = 1,
                idPost = 1
            )
        )

        // выполняем целевое действие
        val result = addedPost.idPost > 0

        // проверяем результат
        assertTrue(result)
    }


}


@Test
fun update_objectFound() {
    // создаём целевой сервис
    val service = WallService()
    // заполняем несколькими постами
    val post1 = Post(

        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post1)
    val post2 = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "Second post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post2)
    // создаём информацию об обновлении
    val update = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post update",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )

    // выполняем целевое действие
    val result = service.update(update)

    // проверяем результат (используйте assertTrue или assertFalse)
    assertTrue(result)
}

@Test
fun update_objectNotFound() {
    // создаём целевой сервис
    val service = WallService()
    // заполняем несколькими постами
    val post1 = Post(

        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post1)
    val post2 = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "Second post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post2)
    // создаём информацию об обновлении
    val update = Post(
        id = 3,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post update",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )

    // выполняем целевое действие
    val result = service.update(update)

    // проверяем результат (используйте assertTrue или assertFalse)
    assertFalse(result)
}

@Test
fun createComment_true() {
    // создаём целевой сервис
    val service = WallService()
    // заполняем несколькими постами
    val post1 = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,

        postponedId = 1,
        idPost = 1
    )
    service.add(post1)
    val post2 = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "Second post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,

        postponedId = 1,
        idPost = 1
    )
    service.add(post2)
    // создаём комментарий к посту
    val comment = Comment(
        id = 115,
        fromId = 695,
        postId = 8,
        date = 10042022,
        text = "Комментарий к посту",
    )

    // выполняем целевое действие
    val result = service.createComment(comment)

    // проверяем результат
    assertTrue(result)
}

@Test(expected = PostNotFoundException::class)
fun shouldThrow() {
    // создаём целевой сервис
    val service = WallService()
    // заполняем несколькими постами
    val post1 = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,

        postponedId = 1,
        idPost = 1
    )
    service.add(post1)
    val post2 = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "Second post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post2)
    // создаём комментарий к посту
    val comment = Comment(
        id = 115,
        fromId = 695,
        postId = 8,
        date = 10042022,
        text = "No comment",
    )

    // выполняем целевое действие
    service.createComment(comment)
}

@Test
fun reportComment_true() {
    // создаём целевой сервис
    val service = WallService()

    // создаем пост
    val post1 = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post1)

    // создаём комментарий к посту
    val comment = Comment(
        id = 115,
        fromId = 695,
        postId = 8,
        date = 10042022,
        text = "Comment for post id = 8",
    )
    service.createComment(comment)

    // создаем жалобу
    val repost = Repost(
        ownerId = 1,
        commentId = 115,
        reason = 0
    )

    // выполняем целевое действие
    val result = service.repostComment(repost)


    // проверяем результат
    assertEquals(1, result)
}

@Test(expected = CommentNotFoundException::class)
fun shouldThrow_CommentNotFoundException() {
    // создаём целевой сервис
    val service = WallService()

    // создаем пост
    val post1 = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post1)

    // создаём комментарий к посту
    val comment = Comment(
        id = 22,
        fromId = 456,
        postId = 1,
        date = 45453432,
        text = "Comment for First post with id = 1"
    )
    service.createComment(comment)
}

@Test(expected = ReasonNotFoundException::class)

fun shouldThrow_ReasonNotFoundExceptionMoreBorder() {
    // создаём целевой сервис
    val service = WallService()

    // создаем пост
    val post1 = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post1)

    // создаём комментарий к посту
    val comment = Comment(
        id = 22,
        fromId = 456,
        postId = 1,
        date = 45453432,
        text = "Comment for First post with id = 1"
    )
    service.createComment(comment)

}

@Test(expected = ReasonNotFoundException::class)
fun shouldThrow_ReasonNotFoundExceptionLessBorder() {
    // создаём целевой сервис
    val service = WallService()

    // создаем пост
    val post1 = Post(
        id = 1,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "First post",
        replyOwnerId = 1,
        replyPostId = 1,
        comments = null,
        copyright = null,
        likes = null,
        reposts = null,
        views = null,
        postType = "1",
        signerId = 1,
        postponedId = 1,
        idPost = 1
    )
    service.add(post1)

    // создаём комментарий к посту
    val comment = Comment(
        id = 22,
        fromId = 456,
        postId = 1,
        date = 45453432,
        text = "Comment for First post with id = 1"
    )
    service.createComment(comment)
}
