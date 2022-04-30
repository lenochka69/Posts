class WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reposts = emptyArray<Repost>()

    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(idPost = 1) else post.copy(idPost = posts.last().idPost + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (p: Post in posts) {
            if (p.id == post.id) {
                val indexPostUpdates = posts.indexOf(p)
                posts[indexPostUpdates] =
                    post.copy(ownerId = posts[indexPostUpdates].ownerId, date = posts[indexPostUpdates].date)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment): Boolean {
        for (p: Post in posts) {
            if (p.id == comment.postId) {
                comments += comment
                return true
            }
        }
        throw PostNotFoundException("no post with id ${comment.postId}")
    }

    fun repostComment(repost: Repost): Int {
        for (comment: Comment in comments) {
            if (comment.id == repost.commentId) {
                if (repost.reason !in 0..8) throw ReasonNotFoundException("no reason with id ${repost.reason}")
                reposts += repost
                return 1
            }
        }
        throw CommentNotFoundException("no comment with id ${repost.commentId}")
    }
}


