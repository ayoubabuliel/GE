import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntryDTO {
    @JsonProperty("API")
    String api;
    @JsonProperty("Description")
    String description;
    @JsonProperty("Auth")
    String auth;
    @JsonProperty("HTTPS")
    boolean https;
    @JsonProperty("Cors")
    String cors;
    @JsonProperty("Link")
    String link;
    @JsonProperty("Category")
    String category;

    public String toString(){
        return "\n" +
                "API= '" + api + "'\n"
                + "Description= '" + description + "'\n"
                + "Auth= '" + auth + "'\n"
                + "HTTPS= '" + https + "'\n"
                + "Cors= '" + cors + "'\n"
                + "Link= '" + link + "'\n"
                + "Category= '" + category + "'\n";
    }
}
