import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';




@Injectable()
export class GenetictableProvider {
  apiKey = 'IvZxJ6tmO9bSDs6wjBK74JE6gwiCK8q9';
  compound;
  url;

  constructor(public http: HttpClient) {
    console.log('Hello GenetictableProvider Provider');
  }

  loadData() {
    this.url = 'https://api.rsc.org/compounds/v1/filter/'+ this.compound + this.apiKey;
    
  
  }

}


