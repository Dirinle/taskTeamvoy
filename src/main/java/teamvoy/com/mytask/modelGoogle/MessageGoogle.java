package teamvoy.com.mytask.modelGoogle;

import teamvoy.com.mytask.modelGoogle.Results;

import java.util.List;

public class MessageGoogle
{
    private List<Results> results;

    private String status;

    public List<Results> getResults ()
    {
        return results;
    }

    public void setResults (List<Results> results)
    {
        this.results = results;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", status = "+status+"]";
    }
}