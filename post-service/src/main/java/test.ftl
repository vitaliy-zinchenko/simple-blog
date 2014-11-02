${message}
<#list countries as country>
${country_index + 1}. ${country}
</#list>
before
<@dir template="k">
    dir content
    ${key}
</@dir>
after
end