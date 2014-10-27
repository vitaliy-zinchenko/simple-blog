<#list posts as post>
    ${post.message}:
    <#list post.comments as comment>
        |${comment.message}|
    </#list>
    </br>
    </br>
</#list>

<div>
    <form action="/post/createComment" method="POST">
        <input type="hidden" name="postId">
        <input name="message">
        <input type="submit">
    </form>
</div>