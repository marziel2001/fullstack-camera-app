import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import {Brands} from "./app/brand/model/brands";
import {HttpClient} from "@angular/common/http";


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
