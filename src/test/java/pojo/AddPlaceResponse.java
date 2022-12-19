package pojo;

public class AddPlaceResponse {

    /* "status": "OK",
    "place_id": "ba958d5b7e0fc6da6c4a0293b2e2f663",
    "scope": "APP",
    "reference": "7d15250b8d12dac7e9773b6aaa812f9f7d15250b8d12dac7e9773b6aaa812f9f",
    "id": "7d15250b8d12dac7e9773b6aaa812f9f"

    */

    private String status;
    private String place_id;
    private String scope;
    private String reference;
    private String id;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
